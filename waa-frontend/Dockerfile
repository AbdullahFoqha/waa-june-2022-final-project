FROM node:alpine3.16
WORKDIR /app
EXPOSE 3000
COPY package* .
RUN npm i
COPY . .
#CMD npm start
ENTRYPOINT ["npm",  "start"]
