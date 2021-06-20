<template>
    <div>
        <h1>欢迎您！尊敬的管理员！</h1>
    </div>
</template>

<script>
export default {
    created(){
        var url = 'http://39.103.202.215:8080/api/staff/list';
        const a = this.$axios.get(url)
        console.log(a)
    }
    
}
</script>
