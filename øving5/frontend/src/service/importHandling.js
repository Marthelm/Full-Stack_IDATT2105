import axios from "axios";
import https from "https";

export function getAllUsers() {
  const res = axios.get("http://localhost:8080/api/users");
  return res;
}

const agent = new https.Agent({
  rejectUnauthorized: false,
});

const config = {
  httpsAgent: agent,
  auth: {
    username: "admin",
    password: "password",
  },
};

export function doLogin(loginRequest) {
  console.log("inside doLogin importHandling");
  return axios
    .post(`http://localhost:8080/api/users`, loginRequest, config)
    .then((resonse) => {
      return resonse.data;
    })
    .catch((err) => {
      console.log(err);
    });
}

export function getUser(username) {
  const s = "http://localhost:8080/api/users/" + username;
  const res = axios.get(s, config);
  return res;
}

export function getAllCalculationsByUser(username) {
  let s = "http://localhost:8080/api/calculations/" + username;
  const res = axios.get(s, config);
  return res;
}
