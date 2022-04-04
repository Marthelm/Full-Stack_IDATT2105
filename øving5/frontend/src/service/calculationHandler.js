export function calculateExpression(num1, num2, op) {
  let s = 0;
  switch (op) {
    case "+":
      s = parseFloat(num1) + parseFloat(num2);
      break;

    case "-":
      s = num1 - num2;
      break;

    case "*":
      s = num1 * num2;
      break;

    case "/":
      s = num1 / num2;
      break;
  }
  return s;
}
