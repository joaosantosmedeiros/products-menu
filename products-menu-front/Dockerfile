FROM node:20.10.0-slim

WORKDIR /app

COPY ./products-menu-front /app

RUN npm install -g @angular/cli

RUN npm install

CMD ["ng", "serve", "--host", "0.0.0.0"]
