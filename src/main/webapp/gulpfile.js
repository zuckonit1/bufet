var path = ".";
var gulp = require('gulp');
var browserify = require('browserify');
var browserSync = require('browser-sync').create();
var plumber = require('gulp-plumber');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var sourcemaps = require('gulp-sourcemaps');
var rename = require("gulp-rename");
var notify = require("gulp-notify");
var babelify = require('babelify');
var source = require('vinyl-source-stream');

gulp.task('serve', ['sass'], function() {
    browserSync.init({
        server: "..",
        notify: false
    });
    gulp.watch(path + "/assets/scss/*.scss", ['sass']);
    gulp.watch(path + "/assets/js/vendors/*.js", ['concat']);
    gulp.watch(path + "/*.html").on('change', browserSync.reload);
});

gulp.task('sass', function() {
    return gulp.src(path + "/css/*.scss")
        .pipe(plumber({errorHandler: notify.onError("Error: <%= error.message %>")}))
        .pipe(sass({outputStyle: 'compressed'}).on('error', sass.logError))
        .pipe(rename("main.min.css"))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(path + "/css/"))
        .pipe(browserSync.stream());
});

gulp.task('concat', function() {
    return gulp.src(path + "/js/libs/*.js")
        .pipe(concat("vendors.js"))
        .pipe(gulp.dest(path + "/js/"));
});

gulp.task('default', function () {
    return browserify('./js/app.js')
        .transform(babelify)
        .bundle()
        .pipe(source('bufet.js'))
        .pipe(gulp.dest('./js/'));
});
