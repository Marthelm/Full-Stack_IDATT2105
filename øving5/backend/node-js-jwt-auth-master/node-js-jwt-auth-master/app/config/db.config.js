module.exports = {
  HOST: "https://mysql-ait.stud.idi.ntnu.no/phpmyadmin/",
  USER: "trygveam",
  PASSWORD: "H9HMBe7p",
  DB: "testdb",
  dialect: "mysql",
  pool: {
    max: 5,
    min: 0,
    acquire: 30000,
    idle: 10000,
  },
};
