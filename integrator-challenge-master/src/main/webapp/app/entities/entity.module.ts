import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'region',
        loadChildren: () => import('./region/region.module').then(m => m.HospitalRegionModule),
      },
      {
        path: 'country',
        loadChildren: () => import('./country/country.module').then(m => m.HospitalCountryModule),
      },
      {
        path: 'location',
        loadChildren: () => import('./location/location.module').then(m => m.HospitalLocationModule),
      },
      {
        path: 'department',
        loadChildren: () => import('./department/department.module').then(m => m.HospitalDepartmentModule),
      },
      {
        path: 'medicine',
        loadChildren: () => import('./medicine/medicine.module').then(m => m.HospitalMedicineModule),
      },
      {
        path: 'task',
        loadChildren: () => import('./task/task.module').then(m => m.HospitalTaskModule),
      },
      {
        path: 'employee',
        loadChildren: () => import('./employee/employee.module').then(m => m.HospitalEmployeeModule),
      },
      {
        path: 'job',
        loadChildren: () => import('./job/job.module').then(m => m.HospitalJobModule),
      },
      {
        path: 'job-history',
        loadChildren: () => import('./job-history/job-history.module').then(m => m.HospitalJobHistoryModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class HospitalEntityModule {}
