
import React from "react";
import axios from "axios";
import {useForm} from "react-hook-form";
import {Link, useNavigate} from "react-router-dom";

const addBalance = () =>{
    const onBalanceSubmit = (data) => {
        const obj1 = {
            name: data.name,
            account_number: data.account_number,
        };
        axios
            .post("", obj1, {withCredentials: true})
            .then((res) => {
                const data = res.data;
            })
            .catch((err) => {
                console.log(err);
            });
    };
    return(
        <div className={"box-card card"}>
            <div className={"card-header"}>
                <h3 className={"mt-1"}>Current Balance</h3>
            </div>
            <div className={"card-body"}>
                <div className={"row"}>
                    <div className={"col-6"}>
                        <div className="registration-form">
                            <form onSubmit={handleSubmit(onBalanceSubmit)}>
                                <div className="form-group">
                                    <input type="text" className="form-control item"
                                           placeholder="Account Holder Name" name={"name"} ref={balance}/>
                                </div>
                                <div className="form-group">
                                    <input type="text" className="form-control item"
                                           placeholder="Account Number" name={"account_number"}
                                           ref={balance}/>
                                </div>
                                <div className="form-group">
                                    <input type="text" className="form-control item" placeholder="Pin"
                                           disabled={"true"} value={"4 2 6 2 7 8"}/>
                                </div>
                                <div className="form-group">
                                    <button type="submit" className="btn btn-block create-account">Check
                                        Balance
                                    </button>
                                </div>
                            </form>
                            <div className="text-center small mt-4 p-3">Don't have an bank
                                account? &nbsp;&nbsp;&nbsp;<Link to={"/home"}>
                                    <button className={"btn btn-outline-secondary"}> Click Here</button>
                                </Link>
                            </div>
                        </div>
                    </div>
                    <div className={"col-6"}>
                        <div className="registration-form">
                            <div className={"balance-box"}>
                                <p className={"balance-title"}>Current Balance :</p>

                                <div className="form-group d-flex item">
                                    <input type="text" className="form-control" placeholder="Account Number"
                                           disabled={"true"}/><p className={"price"}>.Rs</p>
                                </div>
                                <p className={"balance-title"}>Today Date & Time :</p>
                                <div className="form-group d-flex item">
                                    <input type="text" className="form-control" placeholder="Account Number"
                                           value={today.getDate() + ' / ' + (today.getMonth() + 1) + ' / ' + today.getFullYear()}
                                           disabled={"true"}/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
