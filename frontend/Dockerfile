# DOCKER WITH NODE
# FROM node:14-alpine
# WORKDIR /app
# COPY ./package.json ./
# RUN npm i
# COPY . .
# EXPOSE 3000
# CMD ["npm", "run", "start"]


# DOCKER WITH NGINX
FROM node:14-alpine AS builder
WORKDIR /app
COPY package.json .
RUN npm i --force
COPY . .
RUN npm run build


FROM nginx:alpine

WORKDIR /usr/share/nginx/html
COPY --from=builder /app/build .

CMD [ "nginx","-g", "daemon off;" ]
 