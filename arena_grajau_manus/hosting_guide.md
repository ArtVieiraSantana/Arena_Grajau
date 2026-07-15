# Guia de Hospedagem Gratuita - Arena Grajaú

Para hospedar seu site profissional sem custos, recomendo utilizar uma combinação de serviços modernos que oferecem camadas gratuitas generosas.

## 1. Frontend (Angular) no Vercel ou Netlify

Ambos são excelentes para hospedar aplicações Angular de forma gratuita e automática.

### Passo a Passo no Vercel:
1.  **Crie uma conta** em [vercel.com](https://vercel.com) usando seu GitHub.
2.  **Suba seu código** para um repositório no GitHub.
3.  No painel da Vercel, clique em **"Add New"** > **"Project"**.
4.  Importe o repositório da Arena Grajaú.
5.  A Vercel detectará automaticamente que é um projeto Angular e configurará os comandos de build.
6.  Clique em **"Deploy"**. Seu site estará online em um domínio `.vercel.app`.

---

## 2. Backend (Spring Boot) no Render ou Railway

Para o backend em Java, precisamos de um serviço que suporte containers ou execução de JARs.

### Passo a Passo no Render:
1.  Crie uma conta em [render.com](https://render.com).
2.  Clique em **"New"** > **"Web Service"**.
3.  Conecte seu repositório GitHub onde está o código do backend.
4.  Configure o **Runtime** como `Docker` (recomendado) ou use o comando de build nativo:
    *   **Build Command:** `mvn clean package -DskipTests`
    *   **Start Command:** `java -jar target/api-0.0.1-SNAPSHOT.jar`
5.  O Render fornecerá uma URL HTTPS gratuita para sua API.

---

## 3. Conectando os dois
No arquivo `ContactComponent.ts` do Angular, você deve substituir a simulação pela URL real do seu backend no Render:

```typescript
// Exemplo de integração real
this.http.post('https://sua-api-no-render.com/api/contact', data).subscribe(...)
```

## Dicas Importantes:
*   **Domínio Personalizado:** Você pode conectar um domínio `.com.br` (pago) gratuitamente em ambos os serviços.
*   **Dormência:** No plano gratuito do Render, o backend "dorme" após 15 minutos de inatividade. O primeiro acesso após isso pode demorar cerca de 30 segundos para carregar.
*   **Sem Banco de Dados:** Como solicitado, este projeto não requer banco de dados, o que torna a hospedagem ainda mais simples e estável nos planos gratuitos.
