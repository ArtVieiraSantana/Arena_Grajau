import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.component.html'
})
export class ContactComponent {
  submitted = false;

  onSubmit(event: Event) {
    event.preventDefault();
    // Simulação de envio para o backend
    this.submitted = true;
    setTimeout(() => {
      this.submitted = false;
      (event.target as HTMLFormElement).reset();
    }, 5000);
  }
}
