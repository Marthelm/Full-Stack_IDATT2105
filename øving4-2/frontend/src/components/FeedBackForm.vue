<template>
  <form @submit.prevent="handleSubmit">

    <label>Name::</label>
    <input type="name" v-model="name" required>
    <div v-if="nameError" class="error">{{ nameError }}</div>

    <label>Email:</label>
    <input type="email" v-model="email" required>
    <div v-if="emailError" class="error">{{ emailError }}</div>

    <label>Message:</label>
    <p></p>
    <textarea type="message" v-model="message" placeholder="add multiple lines"></textarea>
    <div v-if="messageError" class="error">{{ messageError}}</div>

    <div class="submit">
      <button>Send FeedBack</button>
    </div>
  </form>

  <div v-if="status" class="status">{{ status }}</div>
</template>
<script>
export default {
    state:{
        name:'',
        email:'',
        message:'',
    },
  data() {
    return {
      name:'',
      email: '',
      message:'',
      nameError: null,
      emailError:null,
      messageError:null,
      status:null,
    }
  },
  methods: {
    handleSubmit() {
      // validate password
      this.nameError = this.name.length < 1 ? 'Name Field cant be empty': '' ;
       this.emailError = this.email.length < 1 ? 'Email Field cant be empty': '' ;
       this.messageError = this.message.length < 1 ? 'Message Field cant be empty': '' ;

      if(!this.nameError && !this.emailError && !this.messageError){
          this.status = "Sending"
      }
       setTimeout(function () {

                console.log("sent")

            }, 3000);
    },
  }
}
</script>
<style>
  form {
    max-width: 420px;
    margin: 30px auto;
    background: white;
    text-align: left;
    padding: 40px;
    border-radius: 10px;
  }
  label {
    color: #aaa;
    display: inline-block;
    margin: 25px 0 15px;
    font-size: 0.6em;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: bold;
  }
  input, select {
    display: block;
    padding: 10px 6px;
    width: 100%;
    box-sizing: border-box;
    border: none;
    border-bottom: 1px solid #ddd;
    color: #555;
  }
  input[type="checkbox"] {
    display: inline-block;
    width: 16px;
    margin: 0 10px 0 0;
    position: relative;
    top: 2px;
  }
  .pill {
    display: inline-block;
    margin: 20px 10px 0 0;
    padding: 6px 12px;
    background: #eee;
    border-radius: 20px;
    font-size: 12px;
    letter-spacing: 1px;
    font-weight: bold;
    color: #777;
    cursor: pointer;
  }
  button {
    background: #0b6dff;
    border: 0;
    padding: 10px 20px;
    margin-top: 20px;
    color: white;
    border-radius: 20px;
  }
  .submit {
    text-align: center;
  }
  .error {
    color: #ff0062;
    margin-top: 10px;
    font-size: 0.8em;
    font-weight: bold;
  }
</style>