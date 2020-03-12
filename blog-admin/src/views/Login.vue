<template>
    <div id="login">
        <sign-in id="signin"/>
    </div>
</template>

<script>
import SignIn from "../components/SignIn.vue"
export default {
    name: 'Login',
    components: {
        SignIn
    }
}
</script>
<style scoped>
#signin {
    float: right;
    margin-top: 40px;
    margin-right: 80px;
}
#login {
    background: url(../assets/bg1.png) no-repeat fixed;
    height: 100%;
}
</style>