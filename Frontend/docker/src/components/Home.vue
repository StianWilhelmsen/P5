<template>
  <div class="container">
    <textarea id="codeInput" placeholder="Write code"></textarea>
    <button type="submit" @click="compileCode">Compile Code</button>
    <p class="backendString">{{ output || "No code has been compiled yet.>" }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HomeComponent',
  data() {
    return {
      sourceCode: "",
      output: "",
    };
  },
  methods: {
    async compileCode() {
      const code = {
        sourceCode: document.getElementById('codeInput').value
      };
      console.log(code);
      this.output = (await axios.post("http://localhost:8080/Compile", code)).data;
      this.$forceUpdate(); // force a re-render of the component
    }
  }
}
</script>

<style scoped>
.container {
  width: 10%;
  display:list-item;
}

#codeInput {
  height: 200px;
}
</style>
