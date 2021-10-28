import {BaseEntity} from "../../../../models/entities/BaseEntity";
import {Status} from "../../../../models/types/Status";

export class Contact extends BaseEntity {

  id: number;
  lastName: string;
  firstName: string;
  email: string;
  phoneNumber: string;
  companyId: number;
  comment: string;
  status: Status;

  constructor(id?: number, lastName?: string, firstName?: string, email?: string,
              phoneNumber?: string, companyId?: number, comment?: string, status?: Status) {
    super();
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.companyId = companyId;
    this.comment = comment;
    this.status = status;
  }

  initialize(object: any): Contact {
    this.id = object.id;
    this.lastName = object.lastName;
    this.firstName = object.firstName;
    this.email = object.email;
    this.phoneNumber = object.phoneNumber;
    this.companyId = object.companyId;
    this.comment = object.comment;
    this.status = object.status;

    return this;
  }

}
