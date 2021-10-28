import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {SettingsDialogComponent} from "../settings-dialog/settings-dialog.component";

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openSettingsDialog(): void {
    this.dialog.open(SettingsDialogComponent, {
      height: '40%',
      width: '30%',
      position: {top: '2%'},
      disableClose: true
    });
  }

}
