import axios from "axios";

export function getAllUsers() {
  const res = axios.get("http://localhost:8080/api/users");
  return res;
}

export function getUser(username) {
  const s = "http://localhost:8080/api/users/" + username;
  const res = axios.get(s);
  return res;
}

export function getAllCalculationsByUser(username) {
  let s = "http://localhost:8080/api/calculations/" + username;
  const res = axios.get(s);
  return res;
}
