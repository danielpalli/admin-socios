import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidemenuComponent } from '../../shared/sidemenu/sidemenu.component';
import { HeaderComponent } from '../../shared/header/header.component';

@Component({
  standalone: true,
  imports: [CommonModule, RouterOutlet, SidemenuComponent, HeaderComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export default class DashboardComponent {}
