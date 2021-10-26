import {BaseEntity} from "../../../../models/entities/BaseEntity";
import {Status} from "../../../../models/types/Status";

export class ContactDto extends BaseEntity {

  id: number;
  lastName: string;
  firstName: string;
  email: string;
  phoneNumber: string;
  companyName: string;
  comment: string;
  status: Status;

  constructor(id?: number, lastName?: string, firstName?: string, email?: string,
              phoneNumber?: string, companyName?: string, comment?: string, status?: Status) {
    super();
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.companyName = companyName;
    this.comment = comment;
    this.status = status;
  }

  initialize(object: any): ContactDto {
    this.id = object.id;
    this.lastName = object.lastName;
    this.firstName = object.firstName;
    this.email = object.email;
    this.phoneNumber = object.phoneNumber;
    this.companyName = object.companyName;
    this.comment = object.comment;
    this.status = object.status;

    return this;
  }

}
