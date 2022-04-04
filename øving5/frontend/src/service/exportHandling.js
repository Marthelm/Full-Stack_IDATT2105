import axios from "axios";

export function sendCalculation(num1, num2, op, sol, user) {
  return axios.post("http://localhost:8080/api/calculations", {
    num1: num1,
    num2: num2,
    op: op,
    sol: sol,
    username: user,
  });
}
