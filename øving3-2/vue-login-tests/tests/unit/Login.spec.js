import { shallowMount } from '@vue/test-utils'
import LoginComponent from '@/components/LoginComponent.vue'

describe('LoginComponent.vue', () => {
  it('check that LoginComponent renders', () => {
    const loginTitle = 'Please login!'
    const wrapper = shallowMount(LoginComponent)
    expect(wrapper.text()).toMatch(loginTitle)

    // add some additional checks. For example related to loginStatusLabel element
    // check that loginstatusLabel component exists
    expect(wrapper.find('#loginstatusLabel').exists()).toBe(true);
    const statusId = wrapper.find('#loginstatusLabel');
    // check that id of the loginstatusLabel element is correct
    expect(statusId.element.id).toBe('loginstatusLabel');
    // check that the loginstatusLabel element is displaying correct value
    expect(statusId.element.textContent).toBe('');
  }),
  it('Modify LoginComponent data and test', async () => {
    const wrapper = shallowMount(LoginComponent)

    // get loginstatusLabel element
    const statusId = wrapper.find('#loginstatusLabel');
    // change loginStatus data and check that loginstatusLabel element is updated accordingly
    await wrapper.setData({loginStatus: 'Success'});
    expect(statusId.element.textContent).toBe('Success');
    await wrapper.setData({loginStatus: 'Failed'});
    expect(statusId.element.textContent).toBe('Failed');
  })

  // Exercise
  // Write unit tests for interacting with Login UI elements
  // Such as entering texts on username and pass
  // Clicking Signin button
  // and testing/asserting expected behavior
})