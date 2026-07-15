# Arena Grajaú — site da Escolinha Brigadeiro Faria Lima

Site institucional da escolinha de futebol de bairro **Arena Grajaú**
(fundada em 13/03/1976, no Grajaú - São Paulo).

- **Frontend:** Angular 20 (standalone components), com animações de entrada,
  scroll reveal, header sticky, botão flutuante de WhatsApp e formulário de
  contato.
- **Backend:** Java + Spring Boot 3, expondo só um endpoint (`POST /api/contato`)
  para receber o formulário de contato. **Sem banco de dados** — a mensagem é
  validada e registrada no log do servidor.

```
arena-grajau/
├── backend/     -> API Spring Boot
└── frontend/    -> Site Angular
```

---

## 1. Rodando localmente

### Backend
Pré-requisitos: Java 17+ e Maven instalados.

```bash
cd backend
mvn spring-boot:run
```

A API sobe em `http://localhost:8080`. Teste com:
`http://localhost:8080/api/health`

### Frontend
Pré-requisitos: Node.js 20+ instalado.

```bash
cd frontend
npm install
npm start
```

O site abre em `http://localhost:4200`.

**Antes de tudo**, edite estes dois arquivos e troque pelo número real (com
DDI 55 + DDD + número, sem espaços ou traços):

- `frontend/src/environments/environment.ts`
- `frontend/src/environments/environment.prod.ts`

```ts
whatsappNumero: '5511999999999',
```

---

## 2. Passo a passo para colocar o site no ar de graça

A ideia: **frontend na Netlify** (hospedagem de site estático gratuita) e
**backend no Render** (hospedagem de API Java gratuita). Nenhum dos dois pede
cartão de crédito no plano free.

### Passo 0 — Suba o código para o GitHub
1. Crie uma conta em [github.com](https://github.com) (se ainda não tiver).
2. Crie um repositório novo, por exemplo `arena-grajau`.
3. Dentro da pasta `arena-grajau` (a que contém `backend` e `frontend`), rode:
   ```bash
   git init
   git add .
   git commit -m "Site Arena Grajau"
   git branch -M main
   git remote add origin https://github.com/SEU-USUARIO/arena-grajau.git
   git push -u origin main
   ```

### Passo 1 — Backend no Render (grátis)
1. Crie uma conta em [render.com](https://render.com) usando o GitHub.
2. Clique em **New +** → **Web Service**.
3. Selecione o repositório `arena-grajau`.
4. Configure:
   - **Root Directory:** `backend`
   - **Runtime:** `Java`
   - **Build Command:** `mvn clean package -DskipTests`
   - **Start Command:** `java -jar target/site-1.0.0.jar`
   - **Instance Type:** `Free`
5. Clique em **Create Web Service** e aguarde o build (leva alguns minutos).
6. Quando terminar, o Render mostra uma URL pública, algo como
   `https://arena-grajau-api.onrender.com`. **Guarde essa URL.**

> ⚠️ No plano free, o Render "dorme" o serviço depois de um tempo sem uso.
> A primeira requisição depois disso pode demorar ~30-50 segundos para
> responder — normal, é o servidor "acordando".

### Passo 2 — Aponte o frontend para o backend
Antes de publicar o site, edite:

`frontend/src/environments/environment.prod.ts`

```ts
export const environment = {
  production: true,
  apiUrl: 'https://arena-grajau-api.onrender.com', // URL do Passo 1
  whatsappNumero: '5511999999999',
};
```

Suba essa alteração para o GitHub:
```bash
git add .
git commit -m "Configura URL da API em producao"
git push
```

### Passo 3 — Frontend na Netlify (grátis)
1. Crie uma conta em [netlify.com](https://netlify.com) usando o GitHub.
2. Clique em **Add new site** → **Import an existing project**.
3. Selecione o repositório `arena-grajau`.
4. Configure:
   - **Base directory:** `frontend`
   - **Build command:** `npm run build`
   - **Publish directory:** `frontend/dist/arena-grajau-site/browser`
5. Clique em **Deploy site**. Em 1-2 minutos o site está no ar, em um endereço
   tipo `https://nome-aleatorio.netlify.app`.
6. (Opcional) Em **Site configuration → Domain management** dá para colocar
   um domínio próprio, ou trocar o subdomínio `.netlify.app` por um nome
   melhor, tipo `arena-grajau.netlify.app` — isso também é grátis.

### Passo 4 — Teste tudo
1. Abra o link da Netlify.
2. Preencha o formulário de contato e envie.
3. Se aparecer "Mensagem enviada!", está tudo funcionando.
4. Clique no botão flutuante de WhatsApp e confira se abre a conversa certa.

### Alternativas equivalentes (caso prefira)
- Frontend: **Vercel** ou **GitHub Pages** também são gratuitos e funcionam
  do mesmo jeito (apontando para a pasta `frontend`).
- Backend: **Railway** e **Fly.io** têm planos gratuitos parecidos com o
  Render.

---

## 3. Próximos passos sugeridos (não obrigatórios)
- Trocar as fotos de exemplo da galeria pelas fotos reais dos treinos
  (`frontend/src/app/components/gallery/gallery.component.ts`).
- Preencher o endereço completo do campo em
  `frontend/src/app/components/location/location.component.html`.
- Se um dia quiser guardar as mensagens do formulário em vez de só logar,
  dá pra plugar um envio de e-mail (JavaMailSender) dentro de
  `ContactController.receberMensagem()` — sem precisar de banco de dados.
