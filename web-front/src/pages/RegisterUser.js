import "./CSS/LoginUser.css"
import {useNavigate} from "react-router-dom";
import {useForm} from "react-hook-form";
import axios from "axios";
const RegisterUser = () => {
    const navigate = useNavigate();

    const {register, handleSubmit} = useForm();
    const onSubmit = (data) => {
        const obj = {
            firstName: data.firstName,
            lastName: data.lastName,
            mobile: data.mobile,
            email: data.email,
            password: data.password
        };
        axios
            .post("http://localhost:9090/users", obj, {withCredentials: true})
            .then((res) => {
                console.log(res.data)
                navigate("/", res.data);
            })
            .catch((err) => {
                console.log(err);
            });
    };
    return (
        <div className="login-box container mt-5">
            <div className="login-form">
                <form onSubmit={handleSubmit(onSubmit)}>
                    <div className="avatar"><i className="material-icons">&#xE7FF;</i></div>
                    <h4 className="modal-title">Register to Your Account</h4>
                    <div className="form-group">
                        <input type="text" className="form-control" name={"firstName"} placeholder="First Name" required="required" ref={register}/>
                    </div>
                    <div className="form-group">
                        <input type="text" className="form-control" name={"lastName"} placeholder="Last Name" required="required" ref={register}/>
                    </div>
                    <div className="form-group">
                        <input type="text" className="form-control" name={"mobile"} placeholder="Phone Number" required="required" ref={register}/>
                    </div>
                    <div className="form-group">
                        <input type="text" className="form-control" name={"email"} placeholder="Email Address" required="required" ref={register}/>
                    </div>
                    <div className="form-group">
                        <input type="password" className="form-control" name={"password"} placeholder="Password" required="required" ref={register}/>
                    </div>
                    <div className="form-group small clearfix">
                    </div>
                    <input type="submit" className="btn btn-primary btn-block btn-lg" value="Submit"/>
                </form>
            </div>
        </div>
    );
}

export default RegisterUser;
