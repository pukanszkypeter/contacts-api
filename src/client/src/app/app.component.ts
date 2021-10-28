import {Component} from '@angular/core';
import {MatIconRegistry} from "@angular/material/icon";
import {icons} from "./models/others/Icons";
import {DomSanitizer} from "@angular/platform-browser";
import {TranslateService} from "@ngx-translate/core";

export const LANGUAGE_KEY = 'LANGUAGE';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer, private translate: TranslateService) {
    this.setDefaultLanguage();
    for (let icon of icons) {
      iconRegistry.addSvgIcon(icon.selector, sanitizer.bypassSecurityTrustResourceUrl(icon.path))
    }
  }

  setDefaultLanguage(): void {
    let language = localStorage.getItem(LANGUAGE_KEY);
    if (!language) {
      localStorage.setItem(LANGUAGE_KEY, 'hu');
      this.translate.setDefaultLang('hu')
    } else {
      this.translate.setDefaultLang(language);
    }
  }

}
