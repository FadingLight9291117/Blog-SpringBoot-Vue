<template>
   <div id="information">
        <el-form label-position="left" :model="form" label-width="80px">
            <el-form-item label="账号">
                <el-input v-model="form.account"/>
            </el-form-item>
            <el-form-item label="昵称">
                <el-input v-model="form.name"/>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio v-model="form.gender" label="男">男</el-radio>
                <el-radio v-model="form.gender" label="女">女</el-radio>
            </el-form-item>
            <el-form-item label="年龄">
                <el-input v-model="form.age"/>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="form.phone"/>
            </el-form-item>
            <el-form-item label="QQ">
                <el-input v-model="form.qq"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="modify()">修改</el-button>
                <el-button @click="cancel()">取消</el-button>
            </el-form-item>
        </el-form>      
    </div> 
</template>

<script>
export default {
    name: 'Information',
    data() {
        return {
            form: {
                account: '',
                name: '',
                gender: '',
                age: '',
                phone: '',
                qq: '',
            }
        }
    },
    created() {
        this.$axios
        .get("/admin/getInfo" ,{
                params: {
                    account: "123456@qq.com"
                }
        })
        .then(response => {
            const data = response.data;
            this.form.account = data.admin_account;
            this.form.name = data.nickname;
            this.form.gender = data.sex;
            this.form.age = data.age;
            this.form.phone = data.phone;
            this.form.qq = data.qq_number;
        })
    }
}
</script>

<style scoped>
#information {
    width: 500px;
    text-align: left;
    margin-left: 20%;
}
</style>
