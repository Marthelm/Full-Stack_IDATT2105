<template>
  <div class="wrapper">
    <h3 v-if="signedInStatus">Welcomme {{signedInStatus}}!</h3>
    <h3 v-else>Log In to see your calculations!</h3>

    <div class="calculator" v-if="signedInStatus">
      <div class="display">{{ current || "0" }}</div>
      <div @click="clear" class="btn">C</div>
      <div @click="sign" class="btn">+/-</div>
      <div @click="percent" class="btn">%</div>
      <div @click="divide" class="btn operator">÷</div>
      <div @click="append('7')" class="btn">7</div>
      <div @click="append('8')" class="btn">8</div>
      <div @click="append('9')" class="btn">9</div>
      <div @click="times" class="btn operator">x</div>
      <div @click="append('4')" class="btn">4</div>
      <div @click="append('5')" class="btn">5</div>
      <div @click="append('6')" class="btn">6</div>
      <div @click="minus" class="btn operator">-</div>
      <div @click="append('1')" class="btn">1</div>
      <div @click="append('2')" class="btn">2</div>
      <div @click="append('3')" class="btn">3</div>
      <div @click="add" class="btn operator">+</div>
      <div @click="append('0')" class="btn zero">0</div>
      <div @click="dot" class="btn">.</div>
      <div @click="equal" class="btn operator">=</div>
    </div>
    <div class="log" v-if="signedInStatus">
      <h4>Log of Operations</h4>
      <ul id="example-1" v-if="signedInStatus">
        <li v-for="item in items" :key="item.message" class="list-item" >
          {{ item.message }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import {sendCalculation} from '../service/exportHandling.js'
import {getAllCalculationsByUser} from '../service/importHandling.js'
import {calculateExpression} from '../service/calculationHandler.js'
export default {
  data() {
    return {
      previous: null,
      current: "",
      operator: null,
      operatorSign: null,
      operatorClicked: false,
      items: [],
      signedInStatus: this.$store.state.signedInStatus,
    };
  },
  methods: {
    clear() {
      this.current = "";
    },
    sign() {
      this.current =
        this.current.charAt(0) === "-"
          ? this.current.slice(1)
          : `-${this.current}`;
    },
    percent() {
      const temp = this.current;
      this.current = `${parseFloat(this.current) / 100}`;
      this.items.push({ message: temp + " / 100 = " + this.current });
    },
    append(number) {
      if (this.operatorClicked) {
        this.current = "";
        this.operatorClicked = false;
      }
      this.current = `${this.current}${number}`;
    },
    dot() {
      if (this.current.indexOf(".") === -1) {
        this.append(".");
      }
    },
    setPrevious() {
      this.previous = this.current;
      this.operatorClicked = true;
    },
    divide() {
      this.operator = (a, b) => a / b;
      this.operatorSign = "/";
      this.setPrevious();
    },
    times() {
      this.operator = (a, b) => a * b;
      this.operatorSign = "*";
      this.setPrevious();
    },
    minus() {
      this.operator = (a, b) => a - b;
      this.operatorSign = "-";
      this.setPrevious();
    },
    add() {
      this.operator = (a, b) => a + b;
      this.operatorSign = "+";
      this.setPrevious();
    },
    async equal() {
      const temp = this.current;
      const solution = calculateExpression(this.previous,temp,this.operatorSign);
      this.items.push({ message: this.previous + " " + this.operatorSign + " " + temp + " = " + solution});
      if(this.signedInStatus){
        await sendCalculation(parseFloat(this.previous),parseFloat(temp),this.operatorSign,parseFloat(solution),this.signedInStatus)
      }
      this.current =  solution;
      this.previous = null;
    },
    async checkStatus(){
      const calculations = await getAllCalculationsByUser(this.signedInStatus);
      const d =  calculations.data;
      for(let key in d){
        this.items.push({message:d[key].num1 + " " + d[key].op + " " + d[key].num2 + " = " + d[key].sol});
      }
    },
  },
  beforeMount(){
    this.checkStatus();
  },
};
</script>

<style scoped>
@import url("http://fonts.googleapis.com/css?family=Lato:400,700");
.wrapper {
  display: flex;
  flex-direction: column;
  border-radius: 5px;
}
.calculator {
  margin: 0 auto;
  width: 400px;
  font-size: 40px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(50px, auto);
  border-radius: 5px;
}
.display {
  grid-column: 1 / 5;
  background-color: #93b413;
  color: #000000;
  border-radius: 5px;
}
.zero {
  grid-column: 1 / 3;
}
.btn {
  background-color: #f2f2f2;
  border: 1px solid rgb(93, 91, 91);
  border-radius: 5px;
}
.operator {
  background-color: #e87808;
  color: white;
}
.log {
  width: 400px;
  min-height: 100px;
  margin: 0 auto;
  margin-top: 40px;
  background-color: #4d0909;
  color: white;
}
.list-item {
  text-align: left;
}
</style>
