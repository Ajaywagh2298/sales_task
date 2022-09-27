import "./CSS/LoginUser.css";
import {Link, useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import axios from "axios";



const LoginUser = (props) => {
    const navigate = useNavigate();
    const {register, handleSubmit} = useForm();
    const onSubmit = (data) => {
        const obj = {
            email: data.email,
            password: data.password
        };

        axios
            .post("http://localhost:9090/login", obj, {withCredentials: true})
            .then((res) => {
               let data = res.data;
                navigate("/home",{state:{id:data.id}});
            })
            .catch((err) => {
                console.log(err);
            });
    };
  return (
      <div className="login-box container mt-5">
        <div className="row">
            <div className="col-md-6">
                <div className="login-form">
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="avatar"><i className="material-icons">&#xE7FF;</i></div>
                        <h4 className="modal-title">Login to Your Account</h4>
                        <div className="form-group">
                            <input type="text" className="form-control" name={"email"} placeholder="Email Address" required="required" ref={register}/>
                        </div>
                        <div className="form-group">
                            <input type="password" className="form-control" name={"password"} placeholder="Password" required="required" ref={register}/>
                        </div>
                        <div className="form-group small clearfix">
                        </div>
                        <input type="submit" className="btn btn-primary btn-block btn-lg" value="Login"/>
                    </form>
                    <div className="text-center small">Don't have an account? <Link to={"/register"}>Sign up</Link></div>
                </div>
            </div>
            <div className="col-md-6 p-5 px-5">
                    <div className="animation">
                        <div className="content">
                            <h2>Notes</h2>
                            <p className={"note-text"}>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum</p>
                        </div>
                        <div className="flap"></div>
                    </div>
                </div>
        </div>
      </div>

  );
}
export default LoginUser;
