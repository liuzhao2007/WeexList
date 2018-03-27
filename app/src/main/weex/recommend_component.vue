<template>
    <div class="outterbg">
    <refreshview :display="showLoading"  ref="refreshs" class="list">
    <div class="list">
        <list class="list">
            <cell>
                <image class="header_image" src="http://ox17scdzy.bkt.clouddn.com/18-3-27/87691717.jpg"></image>
            </cell>
            <cell v-for="item in items" @click="itemclick">
                <div style="background-color: #FFDDDD">
                    <div style="margin-left:10px ;margin-top: 20px;margin-right: 20px;background-color: white">
                        <div class="jobname">
                            <text class="tv_jobname">{{item.jobName}}</text>
                            <text class="tv_time">今天</text>
                        </div>
                        <div class="jobname">
                            <text class="tv_salary">{{item.salary}}</text>
                            <image class="img" v-if="item.medal > 0" src="http://ox17scdzy.bkt.clouddn.com/18-3-27/94869582.jpg"></image>
                        </div>
                        <div class="jobarea">
                            <image class="smallimg" src="http://ox17scdzy.bkt.clouddn.com/18-1-12/11695618.jpg"></image>
                            <text class="tv_location" style="padding: 5px;">{{item.workplaceList}}</text>
                            <image class="smallimg" src="http://ox17scdzy.bkt.clouddn.com/18-1-12/90428423.jpg"></image>
                            <text class="tv_location" style="padding: 5px;">{{item.experience}}</text>
                            <image class="smallimg" src="http://ox17scdzy.bkt.clouddn.com/18-1-12/38143824.jpg"></image>
                            <text class="tv_location" style="padding: 5px;">{{item.degree}}</text>
                        </div>
                        <div class="lineviewsmall">
                        </div>
                        <div class="jobarea">
                            <circleImageView :setSrc="item.bphoto" style="width:100;height:100"></circleImageView>
                            <div class="center">
                                <text class="tv_location" style="padding: 5px;">{{item.bnickname}}【{{item.bposition}}】</text>
                                <text class="tv_location">{{item.name}}</text>
                            </div>
                        </div>
                    </div>
                </div>
            </cell>
            <loading class="loading" @loading="onloading" :display="showLoading">
                <text class="indicator">Loading ...</text>
            </loading>
        </list>
        <div class="search">
            <text style="padding: 15px;font-size: 30px;background-color:white;color: #000000">订阅+</text>
            <text style="padding: 15px;font-size: 30px;width: 600px;background-color:white;color: #000000">请输入职位或公司</text>
        </div>
    </div>
    </refreshview>
    </div>
</template>
<script>
var stream = weex.requireModule('stream')
const modal = weex.requireModule('commonmodule')

export default {
    data() {
            return {
                refreshing: false,
                items: [],
                url: 'https://app.chinahr.com/app/job/getJobRecommend',
                page: 1,
                showLoading: 'hide',
                loadingText: '拼命加载中'
            }
        },
        methods: {
            itemclick(){
                modal.toast('click')
            },
            getRecommend(url) {
                var self = this;
                var data = "currpage=" + self.page + "&degree=" + 0;
                self.showLoading = 'show'
                stream.fetch({
                    method: 'POST',
                    type: 'json',
                    url: url,
                    headers: {
                        'cookie': 'PPS="lt=1524724530664&st=1522564530664&lts=9b8f9587f90b&sts=dda593312559&uid=eb07b0e4789a1b57d5041767j&uname=";deviceID=F0F98C85-9F60-4BED-9A2B-0046B39A922A',
                        'deviceid': 'F0F98C85-9F60-4BED-9A2B-0046B39A922A',
                        'uid': 'eb07b0e4789a1b57d5041767j'
                    },
                    body: data
                }, function(res) {
                    try {
                        self.showLoading = 'hide'
                        console.log('get:' + JSON.stringify(res));
                        var results = res.data.data
                        self.refreshing = false
                        if (Array.isArray(results)) {
                            if (self.page == 1) {
                                self.items = []
                            }
                            ++self.page
                            for (var i = 0; i < results.length; i++) {
                                if (typeof(results[i].bphoto) !== 'string') {
                                    results[i].bphoto = "http://ox17scdzy.bkt.clouddn.com/18-3-27/95069176.jpg"
                                }
                                self.items.push(results[i])
                            }
                        }
                        modal.toast('返回：' + results.length)

                    } catch (e) {
                        console.log('获取失败：' + JSON.stringify(res));
                    }
                }, function(res) {})
            },
            onloading(event) {
                modal.toast('loading')
                this.showLoading = 'show'
                this.loadMoreData()
            },
            loadMoreData() {
                var self = this;
                this.getRecommend(self.url)
                modal.toast('执行了')
                self.page++
            }
        },
        created() {
            var self = this;
            self.page = 1;
            this.getRecommend(self.url)
        }
}
</script>
<style rel="stylesheet">
.all {
    background-color: #FFDDDD;
}

.lvitem {
    height: 110px;
    padding: 20px;
    padding-right: 10px;
    align-items: center;
    flex-direction: row;
    justify-content: space-between;
}


.outterbg{
    background-color:#FFDDDD;
    position: absolute;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
}

.list {
    position: absolute;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
    flex: 1;
    background-color: white;
}

.jobname {
    lines: 1;
    padding: 15px;
    flex-direction: row;
    justify-content: space-between;
}

.header_image{
    width: 750px;
    height: 330px;
}

.search{
    margin-top: 20px;
    position: absolute;
    top: 0px;
    left: 0px;
    flex-direction: row;
    background-color:transparent;
    width: 750px; 
    padding-left: 30px;
    padding-right: 30px
}

.center {
    flex: 1;
    padding: 10px;
    flex-direction: column;
    justify-content: center;
}

.smallimg {
    width: 20px;
    height: 20px;
}

.searchimg {
    width: 35px;
    height: 35px;
    padding: 5px;
    align-items: center;
}

.tv_time {
    color: #B3B3B3;
    font-size: 30px;
}

.tv_jobname {
    color: #FF5555;
    font-size: 30px;
}

.tv_salary {
    color: #FF5A5A;
    font-size: 25px;
}

.tv_location {
    color: #B3B3B3;
    font-size: 28px;
}

.lineview {
    background-color: #FFDDDD;
    width: 1000px;
    height: 20px;
}

.img {
    width: 60px;
    height: 35px;
}

.cell {
    border-radius: 25px;
    border-color: #000000;
}

.icon {
    width: 100px;
    height: 100px;
}

.loading {
    justify-content: center;
}

.jobarea {
    lines: 1;
    padding: 15px;
    align-items: center;
    flex-direction: row;
    justify-content: flex-start;
}

.indicator {
    height: 0px;
    color: #888888;
    font-size: 42px;
    padding-top: 20px;
    padding-bottom: 20px;
    text-align: center;
}

.lineviewsmall {
    width: 1000px;
    margin-left: 30px;
    height: 3px;
    background-color: #FFDDDD;
}

.header {
    padding-bottom: 20px;
    background-color: #FFDDDD;
}

.title {
    position: absolute;
    top: 50;
    left: 10;
}

.register {
    position: absolute;
    right: 50px;
    top: 60px;
    padding: 10px;
    border-style: solid;
    align-items: center;
    border-width: 1px;
    border-color: white;
}

.bottom {
    position: absolute;
    top: 260px;
}

.bottomlayout {
    width: 650px;
    lines: 1;
    background-color: #FEADB6;
    border-style: solid;
    border-width: 3px;
    border-color: white;
    color: #aaaaaa;
    padding: 10px;
    margin-left: 35px;
    margin-bottom: 5px;
    flex-direction: row;
}
</style>
