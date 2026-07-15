import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ScrollRevealDirective } from '../../directives/scroll-reveal.directive';

@Component({
  selector: 'app-location',
  standalone: true,
  imports: [ScrollRevealDirective],
  templateUrl: './location.component.html',
  styleUrl: './location.component.scss',
})
export class LocationComponent {
  // TODO: troque pelo endereço exato do campo (Google Maps > Compartilhar > Incorporar mapa)
  readonly mapaUrl: SafeResourceUrl;

  constructor(sanitizer: DomSanitizer) {
    const query = encodeURIComponent('Grajaú, São Paulo - SP');
    this.mapaUrl = sanitizer.bypassSecurityTrustResourceUrl(
      `https://www.google.com/maps?q=${query}&output=embed`
    );
  }
}
