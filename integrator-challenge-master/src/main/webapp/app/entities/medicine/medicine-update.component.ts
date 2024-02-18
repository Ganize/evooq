import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IMedicine, Medicine } from 'app/shared/model/medicine.model';
import { MedicineService } from './medicine.service';

@Component({
  selector: 'jhi-medicine-update',
  templateUrl: './medicine-update.component.html',
})
export class MedicineUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    medicineName: [],
    medicineDescription: [],
  });

  constructor(protected medicineService: MedicineService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ medicine }) => {
      this.updateForm(medicine);
    });
  }

  updateForm(medicine: IMedicine): void {
    this.editForm.patchValue({
      id: medicine.id,
      medicineName: medicine.medicineName,
      medicineDescription: medicine.medicineDescription,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const medicine = this.createFromForm();
    if (medicine.id !== undefined) {
      this.subscribeToSaveResponse(this.medicineService.update(medicine));
    } else {
      this.subscribeToSaveResponse(this.medicineService.create(medicine));
    }
  }

  private createFromForm(): IMedicine {
    return {
      ...new Medicine(),
      id: this.editForm.get(['id'])!.value,
      medicineName: this.editForm.get(['medicineName'])!.value,
      medicineDescription: this.editForm.get(['medicineDescription'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IMedicine>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
