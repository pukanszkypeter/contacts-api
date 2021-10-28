export class ContactsServerRoutes {

  /** BASE ROUTE */
  public static CONTACT_ROUTE = '/contact';

  /** QUERY */
  public static FIND_ALL_ACTIVE = ContactsServerRoutes.CONTACT_ROUTE + '/query/active';
  public static COUNT_ALL_ACTIVE = ContactsServerRoutes.CONTACT_ROUTE + '/query/count/active';

  /** MANIPULATION */
  public static ADD_CONTACT = ContactsServerRoutes.CONTACT_ROUTE + '/manipulation';

}
