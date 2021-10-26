import { Injectable } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {Observable} from "rxjs";

export const LANGUAGE_KEY = "language";

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(private translate: TranslateService) {
    let language = localStorage.getItem(LANGUAGE_KEY);
    if (language == null) {
      language = 'hu';
    }
    translate.setDefaultLang(language);
  }

  switchLanguage(language: string) {
    localStorage.setItem(LANGUAGE_KEY, language);
    this.translate.setDefaultLang(language);
  }

  getLanguageCode(): string {
    const code = localStorage.getItem(LANGUAGE_KEY);
    return code == null ? 'hu' : code;
  }

  getTranslatedText(key: string): Observable<string> {
    return this.translate.get(key);
  }

}
