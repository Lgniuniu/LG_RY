<template>
  <iframe :src="iframeSrc" style="width: 89vw; height: 91.5vh;"></iframe>
</template>
<script>
import {getUrl} from "@/api/system/dim";
export default {
  name: "Dim",
  data() {
    return {
      //iframe 初始地址
      iframeSrc: '',
	  id:'2',
    };
  },
  created() {
    this.getIframeSrc();
  },
  methods: {
    //获取Src
    getIframeSrc() {	  
      getUrl(this.$route.query.fineid).then(response =>{
		  this.iframeSrc=response.msg;
	  });
    }    
}
}
</script>
