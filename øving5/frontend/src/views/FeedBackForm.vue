<template>
  <form @submit.prevent="handleSubmit">
    <label>Name::</label>
    <input :placeholder="name" v-model="name" required />
    <div v-if="nameError" class="error">{{ nameError }}</div>

    <label>Email:</label>
    <input :placeholder="email" v-model="email" required />
    <div v-if="emailError" class="error">{{ emailError }}</div>
    <label>Message</label>
    <input :placeholder="message" v-model="message" />

    <div class="submit">
      <button>Send FeedBack</button>
    </div>
  </form>
  <div class="status">{{ status }}</div>
</template>
<script>
export default {
  state: {},

  data() {
    return {
      nameError: null,
      emailError: null,
      messageError: null,
      status: null,
    };
  },
  methods: {
    handleSubmit() {
      this.nameError = this.name.length < 1 ? "Name Field cant be empty" : "";
      this.emailError =
        this.email.length < 1 ? "Email Field cant be empty" : "";
      this.messageError =
        this.message.length < 1 ? "Message Field cant be empty" : "";

      if (!this.nameError && !this.emailError && !this.messageError) {
        this.status = "SENDING";
        this.activate();
      }
    },
    activate() {
      setTimeout(() => (this.status = "SENT"), 2000);
    },
    updateMessage(e) {
      this.$store.commit("updateMessage", e.target.value);
    },
    updateName(e) {
      this.$store.commit("updateName", e.target.value);
    },
    updateEmail(e) {
      this.$store.commit("updateEmail", e.target.value);
    }
  },
  computed: {
    message: {
      get() {
        return this.$store.state.message;
      },
      set(value) {
        this.$store.commit("updateMessage", value);
      }
    },
    name: {
      get() {
        return this.$store.state.name;
      },
      set(value) {
        this.$store.commit("updateName", value);
      }
    },
    email: {
      get() {
        return this.$store.state.email;
      },
      set(value) {
        this.$store.commit("updateEmail", value);
      }
    },
  },
};
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
input,
select {
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
