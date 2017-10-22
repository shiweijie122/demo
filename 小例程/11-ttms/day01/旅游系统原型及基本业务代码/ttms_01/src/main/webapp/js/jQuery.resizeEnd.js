(function(e, d, a) {
    var b,
        f,
        c;
    c = "resizeEnd";
    f = {
        delay: 250
    };
    b = function(h, g, i) {
        if (typeof g === "function") {
            i = g;
            g = {}
        }
        i = i || null;
        this.element = h;
        this.settings = e.extend({}, f, g);
        this._defaults = f;
        this._name = c;
        this._timeout = false;
        this._callback = i;
        return this.init()
    };
    b.prototype = {
        init: function() {
            var g,
                h;
            h = this;
            g = e(this.element);
            return g.on("resize", function() {
                return h.initResize()
            })
        },
        getUTCDate: function(h) {
            var g;
            h = h || new Date();
            g = Date.UTC(h.getUTCFullYear(), h.getUTCMonth(), h.getUTCDate(), h.getUTCHours(), h.getUTCMinutes(), h.getUTCSeconds(), h.getUTCMilliseconds());
            return g
        },
        initResize: function() {
            var g;
            g = this;
            g.controlTime = g.getUTCDate();
            if (g._timeout === false) {
                g._timeout = true;
                return setTimeout(function() {
                    return g.runCallback(g)
                }, g.settings.delay)
            }
        },
        runCallback: function(h) {
            var g;
            g = h.getUTCDate();
            if (g - h.controlTime < h.settings.delay) {
                return setTimeout(function() {
                    return h.runCallback(h)
                }, h.settings.delay)
            } else {
                h._timeout = false;
                return h._callback()
            }
        }
    };
    return e.fn[c] = function(g, h) {
        return this.each(function() {
            if (!e.data(this, "plugin_" + c)) {
                return e.data(this, "plugin_" + c, new b(this, g, h))
            }
        })
    }
})(jQuery, window, document);

