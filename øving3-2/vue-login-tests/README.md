# Goals - add more unit tests to Login UI

## Compile, Run the project and inspect the page

Note - This project is a Frontend app and need a backend API to work (see next section about using a backend) 

Checkout this locally https://gitlab.com/sysdev-tutorials/vuejs/02-my-vue-project/-/tree/12-final

```
# download dependencies (one time operation or do it again when new libraries are added)
npm install 
# compile and hot-reload for development
npm run serve
# inspect page contents
```

## Run a backend demo API locally 

Locally checkout this repo: https://gitlab.com/sysdev-tutorials/springboot/auth_demo/-/tree/test.
Switch to 'test' branch. Then from the project folder, run

```
mvn spring-boot:run
```

Note the context path and port number given src/main/resources/application.properties file.
Correct port should be used from frontend part.

## Refactor API call related code from LoginComponent

Create a new file ```src/utils/apiutil.js ``` with the folloing contents
```
import axios from "axios";

export function doLogin (loginRequest) {
    return axios.post(`http://localhost:8085/demo/login`, loginRequest).then(resonse => {
      return resonse.data;
    });
}
```

## Update LoginComponent.vue based on the above refactor
Updated LoginComponent has ```Script``` part as following. Note the ```import``` statement, and ```doLogin``` function call in  ```handleClickSignin``` and ```handleClickSignin_2``` methods.
```
  <script>
  import { doLogin } from '@/utils/apiutil.js'

  export default {
    name: 'LoginComponent',
    methods: {
      async handleClickSignin (){
        //alert("You entered, username: " + this.username);
        const loginRequest = { username:this.username, password: this.password };
        const loginResponse = await doLogin(loginRequest);
        console.log(loginResponse);
        alert("Login: " + loginResponse.loginStatus);
      },
      handleClickSignin_2 () {
        const loginRequest = { username: this.username, password: this.password };
        const loginResponse = doLogin(loginRequest);
        console.log(loginResponse)
        loginResponse.then((resolvedResult) => {
          this.loginStatus = resolvedResult.loginStatus;
          // alert("Login2: " + resolvedResult.loginStatus);
        });
      },

    },
    data() {
      return {
        username: '',
        password: '',
        loginStatus: '',
      }
    }

  }
  </script>
```

Run ```npm run serve``` and make sure that app is working as expected.

## Write tests for API calls
Add a new test file ```test/unit/apiutil.spec.js``` with following content. It has two test - one for testing Success and another for testing Fail scenario.
 
```
import { doLogin } from '@/utils/apiutil'

describe('testing apiutil.vue', () => {
    it('test API call utility function - login Success', async () => {
      const loginRequest = { username:"user", password: "pass" };
      const loginResponse = await doLogin(loginRequest);  
      const expectedLoginRespone = { loginStatus: 'Success' };
      expect(loginResponse).toEqual(expectedLoginRespone);
    }),
    it('test API call utility function - login Fail', async () => {
        const loginRequest = { username:"userx", password: "passx" };
        const loginResponse = await doLogin(loginRequest);  
        const expectedLoginRespone = { loginStatus: 'Fail' };
        expect(loginResponse).toEqual(expectedLoginRespone);
    })
  })
```

And, run ```npm run test:unit```command

Note: Here backend demo should be running inorder for test to succeed.

Next, we will MOCK the API call so that we can test API call utilitie without actually needing a real backend server running
