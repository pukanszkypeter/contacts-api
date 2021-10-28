export class BlockList {

  id: number;
  domain: string;

  constructor(id?: number, domain?: string) {
    this.id = id;
    this.domain = domain;
  }

  initialize(object: any): BlockList {
    this.id = object.id;
    this.domain = object.domain;

    return this;
  }

}
