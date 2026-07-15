import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styles: [`
    .nav-link {
      font-weight: 500;
      transition: color 0.3s ease;
      &:hover {
        color: var(--primary-color) !important;
      }
    }
  `]
})
export class HeaderComponent {}
