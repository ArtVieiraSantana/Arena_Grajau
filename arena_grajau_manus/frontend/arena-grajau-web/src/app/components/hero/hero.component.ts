import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './hero.component.html',
  styles: [`
    .hero-section {
      position: relative;
      overflow: hidden;
    }
  `]
})
export class HeroComponent {}
