<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex, nofollow">
<meta name="googlebot" content="noindex, nofollow">
<script type="text/javascript" src="/js/lib/dummy.js"></script>
<link rel="stylesheet" type="text/css" href="/css/result-light.css">
<script type="text/javascript"
	src="http://fb.me/react-with-addons-0.12.0.js"></script>
<script type="text/javascript"
	src="http://fb.me/JSXTransformer-0.12.0.js"></script>
<style type="text/css">
</style>
<title>React</title>
<script type="text/javascript">
var MyApp = React.createClass({
  getInitialState: function(){
      return {
          firstName: this.props.firstName,
          lastName:  this.props.lastName,
      }
  },
  handleChange: function(){
      var firstName = this.refs.firstName.getDOMNode().value;
      var lastName = this.refs.lastName.getDOMNode().value;
      this.setState({
          firstName: firstName,
          lastName: lastName,
              });
  },
  render: function() {
    var fullName = this.state.firstName + this.state.lastName;
    return (
        <div>
        First name: <input ref="firstName" onChange={this.handleChange} value={this.state.firstName}/><br/>
        Last name: <input ref="lastName" onChange={this.handleChange} value={this.state.lastName}/><br/>
        Full name: {fullName}
        </div>);
  }
});

React.render(<MyApp firstName="Eldon" lastName="Olmstead" />, document.body);

</script>
</head>
<body>
	
</body>
</html>