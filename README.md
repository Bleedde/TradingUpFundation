TradingUpFundation

This is a web site for an academy that offers trading courses called Trading Up Foundation, the purpose of this website is make easier the processes of analysis and following of the students of this academy for their teachers

Index 

- Instalation
- Proyect structure
- Contributors
- Contacts

INSTALATION
System requirements:
- Java 17 or 21
- Angular 15
- Create dependencies in Angular:
    -npm install
- Clone the repository with commands:
  - git clone https://github.com/Bledde/TradingUpFundation.git
  - cd your-global-proyect/backend
  - cd your-global-ptoyect/frontend
- Should be created a database with the name "trading_up_foundation"
- Connect the proyecto with ur MySQL database with commands in the properties of the backend: 
  - spring.datasource.url=jdbc:mysql://localhost:yourport/trading_up_foundation
  - spring.datasource.username=yourusername
  - spring.datasource.password=yourpassword
- Execute the database
- Execute the backend woth this command: 
  - ./mvnw spring-boot:run
- Execute the frontend
  - ng serve
The aplication will be available in localhost:4200

PROYECT STRUCTURE

This proyect was developed using hexaghonal arqhitecture, so the main folders in this proyect and their means are: 
- Domains: creation of objects
- Repositories: Connections with database
- Services: Buisness logic and conections betwen objects
- Controllers: Send and receiving of information from a place to another one

CONTRIBUTORS

Its an honor for us to recognize and emphazise the colaboration of this people in the life of the TradingUpFoundation software develope, they are: 
- Diego Esteban Vera Enciso: For his contribution in the resources of the develope and the adition of hexagonal arqhitecture
- Jhon Edwin Castro Gaspar: For give us an IntelliJ Ulltimate account
- Laura Valentina Trujillo: For explain and clarify some important points whic guide us to finalize succesfully the desing phase

CONTACTS

If your are interested of know more about this proyect, below this line you can find the emails of all the integrants of the workteam: 
- Brahian Barrios: ttreyygh@gmail.com
- Juan Ospina: pataca0987@gmail.com
- Andres Perez: edisonandresperezmartinez@gmail.com
- Laura Orjuela: ljorjuela59@gmail.com
- James Acosta: jamesesteb15@gmail.com
- Gustavo Garzon: Androidesito18@gmail.com
