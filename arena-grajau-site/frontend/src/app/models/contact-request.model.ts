export interface ContactRequest {
  nome: string;
  telefone: string;
  email: string;
  mensagem: string;
}

export interface ContactResponse {
  sucesso: boolean;
  mensagem?: string;
  erros?: Record<string, string>;
}
