gulp.task('travis',[ 'build', 'testServerJS'], function() {
	process.exit(0);
});
gulp.task('lint-css', function lintCssTask() {
  return gulp
    .src('src/**/*.css')
    .pipe(gulpStylelintCheckstyle({
      stylelint: {
        extends: 'stylelint-config-suitcss'
      },
      output: 'reports/lint/lint-css.xml',
      reportToConsole: true,
      failAfterAllErrors: true
    }));
});
