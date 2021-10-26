import { Component } from '@angular/core';
import {MatIconRegistry} from "@angular/material/icon";
import {icons} from "./models/others/Icons";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    for (let icon of icons) {
      iconRegistry.addSvgIcon(icon.selector, sanitizer.bypassSecurityTrustResourceUrl(icon.path))
    }
  }

}
