import axios from "axios";

export function getAllUsers() {
  return axios.get("http://localhost:8080/api/users/trygve").then((answer) => {
    return answer.data;
  });
}

export function getAllCalculationsByUser(username) {
  return axios
    .get("http://localhost:8080/api/users/" + { username })
    .then((answer) => {
      return answer.data;
    });
}
