<template>
  <iframe :src="iframeSrc" style="width: 90.5vw; height: 92vh;"></iframe>
</template>
<script>
import {getUrl} from "@/api/system/dim";
export default {
  name: "Report",
  data() {
    return {
      //iframe 初始地址
      iframeSrc: '',
	  id:'1',
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
