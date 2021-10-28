export class Company {

  id: number;
  name: string;

  constructor(id?: number, name?: string) {
    this.id = id;
    this.name = name;
  }

  initialize(object: any): Company {
    this.id = object.id;
    this.name = object.name;

    return this;
  }

}
