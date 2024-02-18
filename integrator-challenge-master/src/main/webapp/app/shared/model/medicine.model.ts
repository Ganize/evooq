export interface IMedicine {
  id?: number;
  medicineName?: string;
  medicineDescription?: string;
}

export class Medicine implements IMedicine {
  constructor(public id?: number, public medicineName?: string, public medicineDescription?: string) {}
}
