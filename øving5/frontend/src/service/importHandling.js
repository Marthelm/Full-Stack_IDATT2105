import axios from "axios";

export function getAllUsers() {
  axios.get("http://localhost:8080/api/users/trygve").then((answer) => {
    return answer.data;
  });
}

export function test() {
  const res = axios.get("http://localhost:8080/api/users/trygve");
  return res;
}

export function getAllCalculationsByUser(username) {
  return axios
    .get("http://localhost:8080/api/users/" + { username })
    .then((answer) => {
      return answer.data;
    });
}
