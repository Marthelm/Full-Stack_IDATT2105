console.log("hello");
generateListOfWords();
let count = 0;

function updateValue() {
  count++;
  document.getElementById("countField").innerHTML = count;
}

function toogleVisibility() {
  let visible = document.getElementById("textField").style.display;
  if (visible == "block") {
    document.getElementById("textField").style.display = "none";
  } else {
    document.getElementById("textField").style.display = "block";
  }
}

function generateListOfWords() {
  const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
  ];
  // method of getting random word from list of months
  const random = Math.floor(Math.random() * months.length);
  const listElement = document.getElementById("list");
  months.forEach(function (item) {
    const li = document.createElement("li");
    li.appendChild(document.createTextNode(item));
    listElement.appendChild(li);
  });
}
