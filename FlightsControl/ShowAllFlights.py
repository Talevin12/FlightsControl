import subprocess

from flask import Flask, request, redirect, url_for
import urllib.parse

app = Flask("natbag2020_app")


@app.route("/departures")
def departures():
    return subprocess.check_output(["java", "-classpath",
                                    "C:\\Users\\talev\\git\\FlightsControl\\FlightsControl\\bin", "FlightsControl"
                                                                                                  ".program",
                                    request.args.get('outformat'), "departures",
                                    request.args.get('airline'), request.args.get('country'),
                                    request.args.get('city'), request.args.get('airport'),
                                    request.args.get('day1'), request.args.get('month1'),
                                    request.args.get('year1'), request.args.get('day2'),
                                    request.args.get('month2'), request.args.get('year2'),
                                    request.args.get('sunday'), request.args.get('monday'),
                                    request.args.get('tuesday'), request.args.get('wednesday'),
                                    request.args.get('thursday'), request.args.get('friday'),
                                    request.args.get('saturday')])


@app.route("/arrivals")
def arrivals():
    return subprocess.check_output(["java", "-classpath",
                                    "C:/Users/talev/git/FlightsControl/FlightsControl/bin", "FlightsControl.program",
                                    request.args.get('outformat'), "arrivals",
                                    request.args.get('airline'), request.args.get('country'),
                                    request.args.get('city'), request.args.get('airport'),
                                    request.args.get('day1'), request.args.get('month1'),
                                    request.args.get('year1'), request.args.get('day2'),
                                    request.args.get('month2'), request.args.get('year2'),
                                    request.args.get('sunday'), request.args.get('monday'),
                                    request.args.get('tuesday'), request.args.get('wednesday'),
                                    request.args.get('thursday'), request.args.get('friday'),
                                    request.args.get('saturday')])


@app.route("/filterFlights", methods=('GET', 'POST'))
def filter():
    if request.method == 'POST':
        print ('got a post request')

        # str = request.form['airport']
        # print(str)

        # url_params = f"outformat=html&country={request.form['country']}&city={request.form['city']}&airport={request.form['airport']}&airline={request.form['airline']}&day1={request.form['day1']}&month1={request.form['month1']}&year1={request.form['year1']}&day2={request.form['day2']}&month2={request.form['month2']}&year2={request.form['year2']}&sunday=false&monday=false&tuesday=false&wednesday=true&thursday=false&friday=true&saturday=false"
        # url_params = urllib.parse.quote(url_params)
        # print(url_params)

        red_url = f"{request.form['type']}"
        print(red_url)

        return redirect(url_for(red_url,
                        outformat="html", country=request.form['country'], city=request.form['city'], airport=request.form['airport'],
                                airline=request.form['airline'], day1=request.form['day1'], month1=request.form['month1'],
                                year1=request.form['year1'], day2=request.form['day2'], month2=request.form['month2'],
                                year2=request.form['year2'], sunday=request.form['days'] == "sunday", monday=request.form['days'] == "monday", tuesday=request.form['days'] == "tuesday",
                                wednesday=request.form['days'] == "wednesday", thursday=request.form['days'] == "thursday",
                                friday=request.form['days'] == "friday",
                                saturday=request.form['days'] == "saturday"))

    else:
        return subprocess.check_output(["java", "-classpath",
                                        "C:/Users/talev/git/FlightsControl/FlightsControl/bin",
                                        "FlightsControl.program",
                                        request.args.get('outformat'), "sort"])


app.run(port=8000, host="0.0.0.0")
