import axios from "axios";

export function sendExpression(num1, num2, op,username) {
  return axios.post("http://localhost:8081/user/" + {username}, {
    num1: num1,
    num2: num2,
    op: op,
  });
}

export function getAllUsers(){
  return axios.get("http://localhost:8081/user/all").then((answer) => {
    return answer.data;
  })
}

export function getAllCalculationsByUser(username){
  return axios.get("http://localhost:8081/user/" + {username}).then((answer) => {
    return answer.data;
  })
}
