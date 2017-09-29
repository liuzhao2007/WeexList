// { "framework": "Vue" }
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = []

	/* styles */
	__vue_styles__.push(__webpack_require__(1)
	)

	/* script */
	__vue_exports__ = __webpack_require__(2)

	/* template */
	var __vue_template__ = __webpack_require__(6)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "/Users/liuzhao/Desktop/学习/Weex/recommend.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__.style = __vue_options__.style || {}
	__vue_styles__.forEach(function (module) {
	for (var name in module) {
	__vue_options__.style[name] = module[name]
	}
	})

	module.exports = __vue_exports__
	module.exports.el = 'true'
	new Vue(module.exports)


/***/ },
/* 1 */
/***/ function(module, exports) {

	module.exports = {
	  "itembg": {
	    "backgroundColor": "#FFDDDD"
	  },
	  "outterbg": {
	    "backgroundColor": "#FFDDDD",
	    "position": "absolute",
	    "top": 0,
	    "left": 0,
	    "right": 0,
	    "bottom": 0
	  },
	  "list": {
	    "position": "absolute",
	    "top": 0,
	    "left": 0,
	    "right": 0,
	    "bottom": 0,
	    "flex": 1,
	    "backgroundColor": "#FFFFFF"
	  },
	  "jobname": {
	    "lines": 1,
	    "padding": 15,
	    "flexDirection": "row",
	    "justifyContent": "space-between"
	  },
	  "header_image": {
	    "width": 750,
	    "height": 330
	  },
	  "search": {
	    "marginTop": 20,
	    "position": "absolute",
	    "top": 0,
	    "left": 0,
	    "flexDirection": "row",
	    "backgroundColor": "rgba(0,0,0,0)",
	    "width": 750,
	    "paddingLeft": 30,
	    "paddingRight": 30
	  },
	  "center": {
	    "flex": 1,
	    "padding": 10,
	    "flexDirection": "column",
	    "justifyContent": "center"
	  },
	  "smallimg": {
	    "width": 20,
	    "height": 20
	  },
	  "searchimg": {
	    "width": 35,
	    "height": 35,
	    "padding": 5,
	    "alignItems": "center"
	  },
	  "tv_time": {
	    "color": "#B3B3B3",
	    "fontSize": 30
	  },
	  "tv_jobname": {
	    "color": "#FF5555",
	    "fontSize": 30
	  },
	  "tv_salary": {
	    "color": "#FF5A5A",
	    "fontSize": 25
	  },
	  "tv_location": {
	    "color": "#B3B3B3",
	    "fontSize": 28
	  },
	  "lineview": {
	    "backgroundColor": "#FFDDDD",
	    "width": 1000,
	    "height": 20
	  },
	  "img": {
	    "width": 60,
	    "height": 35
	  },
	  "cell": {
	    "borderRadius": 25,
	    "borderColor": "#000000"
	  },
	  "icon": {
	    "width": 100,
	    "height": 100
	  },
	  "loading": {
	    "justifyContent": "center"
	  },
	  "jobarea": {
	    "lines": 1,
	    "padding": 15,
	    "alignItems": "center",
	    "flexDirection": "row",
	    "justifyContent": "flex-start"
	  },
	  "indicator": {
	    "height": 0,
	    "color": "#888888",
	    "fontSize": 42,
	    "paddingTop": 20,
	    "paddingBottom": 20,
	    "textAlign": "center"
	  },
	  "lineviewsmall": {
	    "width": 1000,
	    "marginLeft": 30,
	    "height": 3,
	    "backgroundColor": "#FFDDDD"
	  },
	  "header": {
	    "paddingBottom": 20,
	    "backgroundColor": "#FFDDDD"
	  },
	  "title": {
	    "position": "absolute",
	    "top": 50,
	    "left": 10
	  },
	  "register": {
	    "position": "absolute",
	    "right": 50,
	    "top": 60,
	    "padding": 10,
	    "borderStyle": "solid",
	    "alignItems": "center",
	    "borderWidth": 1,
	    "borderColor": "#FFFFFF"
	  },
	  "bottom": {
	    "position": "absolute",
	    "top": 260
	  },
	  "bottomlayout": {
	    "width": 650,
	    "lines": 1,
	    "backgroundColor": "#FEADB6",
	    "borderStyle": "solid",
	    "borderWidth": 3,
	    "borderColor": "#FFFFFF",
	    "color": "#aaaaaa",
	    "padding": 10,
	    "marginLeft": 35,
	    "marginBottom": 5,
	    "flexDirection": "row"
	  }
	}

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _stringify = __webpack_require__(3);

	var _stringify2 = _interopRequireDefault(_stringify);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var stream = weex.requireModule('stream');
	var modal = weex.requireModule('modal');
	exports.default = {
	    data: function data() {
	        return {
	            refreshing: false,
	            items: [],
	            url: 'https://app.chinahr.com/app/job/getJobRecommend',
	            page: 1,
	            showLoading: 'hide',
	            loadingText: '拼命加载中',
	            weexStar: 'unknown',
	            vueStar: 'unknown'
	        };
	    },

	    methods: {
	        getRecommend: function getRecommend(url) {
	            var self = this;
	            var data = "currpage=" + self.page + "&degree=" + 0;
	            stream.fetch({
	                method: 'POST',
	                type: 'json',
	                url: url,
	                headers: {
	                    'cookie': 'PPS=lt=1504706800383&st=1502546800383&lts=32847949a5b5&sts=0b6939ca9692&uid=eb07b0e4789a1b57d5041767j&uname=;deviceID=355590362038182',
	                    'deviceid': '863952039798457',
	                    'uid': 'eb07b0e4789a1b57d5041767j'
	                },
	                body: data
	            }, function (res) {
	                try {
	                    self.showLoading = 'hide';
	                    console.log('get:' + (0, _stringify2.default)(res));
	                    var results = res.data.data;
	                    self.refreshing = false;
	                    if (Array.isArray(results)) {
	                        if (self.page == 1) {
	                            self.items = [];
	                        }
	                        ++self.page;
	                        for (var i = 0; i < results.length; i++) {
	                            if (typeof results[i].bphoto !== 'string') {
	                                results[i].bphoto = "http://i1.bvimg.com/602735/24e7a9d036063a9f.png";
	                            }
	                            self.items.push(results[i]);
	                        }
	                    }
	                    modal.toast({
	                        message: '返回：' + results.length,
	                        duration: 0.8
	                    });
	                } catch (e) {
	                    console.log('获取失败：' + (0, _stringify2.default)(res));
	                }
	            }, function (res) {});
	        },
	        onloading: function onloading(event) {
	            modal.toast({
	                message: 'loading',
	                duration: 1
	            });
	            this.showLoading = 'show';
	            this.loadMoreData();
	        },
	        loadMoreData: function loadMoreData() {
	            var self = this;
	            this.getRecommend(self.url);
	            modal.toast({
	                message: '执行了',
	                duration: 0.8
	            });
	            self.page++;
	        }
	    },
	    created: function created() {
	        var self = this;
	        self.page = 1;
	        this.getRecommend(self.url);
	    }
	};
	module.exports = exports['default'];

/***/ },
/* 3 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = { "default": __webpack_require__(4), __esModule: true };

/***/ },
/* 4 */
/***/ function(module, exports, __webpack_require__) {

	var core  = __webpack_require__(5)
	  , $JSON = core.JSON || (core.JSON = {stringify: JSON.stringify});
	module.exports = function stringify(it){ // eslint-disable-line no-unused-vars
	  return $JSON.stringify.apply($JSON, arguments);
	};

/***/ },
/* 5 */
/***/ function(module, exports) {

	var core = module.exports = {version: '2.4.0'};
	if(typeof __e == 'number')__e = core; // eslint-disable-line no-undef

/***/ },
/* 6 */
/***/ function(module, exports) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', {
	    staticClass: ["outterbg"]
	  }, [_c('list', {
	    staticClass: ["list"]
	  }, [_vm._m(0), _vm._l((_vm.items), function(item) {
	    return _c('cell', {
	      appendAsTree: true,
	      attrs: {
	        "append": "tree"
	      }
	    }, [_c('div', {
	      staticClass: ["itembg"]
	    }, [_c('div', {
	      staticStyle: {
	        marginLeft: "10px",
	        marginTop: "20px",
	        marginRight: "20px",
	        backgroundColor: "white"
	      }
	    }, [_c('div', {
	      staticClass: ["jobname"]
	    }, [_c('text', {
	      staticClass: ["tv_jobname"]
	    }, [_vm._v(_vm._s(item.jobName))]), _c('text', {
	      staticClass: ["tv_time"]
	    }, [_vm._v("今天")])]), _c('div', {
	      staticClass: ["jobname"]
	    }, [_c('text', {
	      staticClass: ["tv_salary"]
	    }, [_vm._v(_vm._s(item.salary))]), (item.medal > 0) ? _c('image', {
	      staticClass: ["img"],
	      attrs: {
	        "src": "http://i1.piimg.com/567571/6cd980d1b219c912.png"
	      }
	    }) : _vm._e()]), _c('div', {
	      staticClass: ["jobarea"]
	    }, [_c('image', {
	      staticClass: ["smallimg"],
	      attrs: {
	        "src": "http://p1.bqimg.com/567571/7ab7705afa1b2ade.png"
	      }
	    }), _c('text', {
	      staticClass: ["tv_location"],
	      staticStyle: {
	        padding: "5px"
	      }
	    }, [_vm._v(_vm._s(item.workplaceList))]), _c('image', {
	      staticClass: ["smallimg"],
	      attrs: {
	        "src": "http://i1.piimg.com/567571/5b22e11296a19844.png"
	      }
	    }), _c('text', {
	      staticClass: ["tv_location"],
	      staticStyle: {
	        padding: "5px"
	      }
	    }, [_vm._v(_vm._s(item.experience))]), _c('image', {
	      staticClass: ["smallimg"],
	      attrs: {
	        "src": "http://i1.piimg.com/567571/3a2b4625133f0f45.png"
	      }
	    }), _c('text', {
	      staticClass: ["tv_location"],
	      staticStyle: {
	        padding: "5px"
	      }
	    }, [_vm._v(_vm._s(item.degree))])]), _c('div', {
	      staticClass: ["lineviewsmall"]
	    }), _c('div', {
	      staticClass: ["jobarea"]
	    }, [_c('circleImageView', {
	      staticStyle: {
	        width: "100",
	        height: "100"
	      },
	      attrs: {
	        "setSrc": item.bphoto
	      }
	    }), _c('div', {
	      staticClass: ["center"]
	    }, [_c('text', {
	      staticClass: ["tv_location"],
	      staticStyle: {
	        padding: "5px"
	      }
	    }, [_vm._v(_vm._s(item.bnickname) + "【" + _vm._s(item.bposition) + "】")]), _c('text', {
	      staticClass: ["tv_location"]
	    }, [_vm._v(_vm._s(item.name))])])], 1)])])])
	  }), _c('loading', {
	    staticClass: ["loading"],
	    attrs: {
	      "display": _vm.showLoading
	    },
	    on: {
	      "loading": _vm.onloading
	    }
	  }, [_c('text', {
	    staticClass: ["indicator"]
	  }, [_vm._v("Loading ...")])])], 2), _vm._m(1)])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('cell', {
	    appendAsTree: true,
	    attrs: {
	      "append": "tree"
	    }
	  }, [_c('image', {
	    staticClass: ["header_image"],
	    attrs: {
	      "src": "http://i2.bvimg.com/602735/4d1760963a9516ae.png"
	    }
	  })])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
	  return _c('div', {
	    staticClass: ["search"]
	  }, [_c('text', {
	    staticStyle: {
	      padding: "15px",
	      fontSize: "30px",
	      backgroundColor: "white",
	      color: "#000000"
	    }
	  }, [_vm._v("订阅+")]), _c('text', {
	    staticStyle: {
	      padding: "15px",
	      fontSize: "30px",
	      width: "600px",
	      backgroundColor: "white",
	      color: "#000000"
	    }
	  }, [_vm._v("请输入职位或公司")])])
	}]}
	module.exports.render._withStripped = true

/***/ }
/******/ ]);